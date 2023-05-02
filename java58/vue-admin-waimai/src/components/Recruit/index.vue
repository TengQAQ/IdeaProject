<template>
  <!-- 新增和修改对话框-->
  <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body :close-on-click-modal="false"
    :before-close="cancelForm">
    <el-form ref="form" :model="form" label-width="100px">

      <el-form-item label="商家名称"    >
         {{form.name}}
      </el-form-item>

      <el-form-item label="联系电话"   >
         {{form.phone}}
      </el-form-item>

      <el-form-item label="地图位置"  style="text-align:left;">
        <span>经度:{{form.longitude}} 纬度:{{form.latitude}}</span>
      </el-form-item>

      <el-form-item label="商家地址"  >
        {{form.address}}
      </el-form-item>

      <el-form-item label="商家图片" >
       <img v-if="form.picture" :src="form.picture" class="avatar">
       <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-form-item>

      <el-form-item label="审核" prop="status" :rules="[  { required: true, message: '该值不能为空', trigger: 'blur' }]" >
         <el-radio-group v-model="form.status">
            <el-radio v-for="item in dicts.process" v-if="item.value!==1" v-bind:key="item.value"   :label="item.value">{{item.label}}</el-radio>
          </el-radio-group>
      </el-form-item>

     <el-form-item label="备注信息"  >
       <el-input
         type="textarea"
         :rows="2"
         placeholder="请输入内容"
          maxlength="30"
          show-word-limit
         v-model="form.description">
       </el-input>
      </el-form-item>


    </el-form>

    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitForm">确 定</el-button>
      <el-button @click="cancelForm">取 消</el-button>
    </div>
  </el-dialog>
</template>

<script>
   import DictMixin from '@/mixins/DictMixin.js'
   import {processApi} from '@/api/enterprise.js'
  export default {
    mixins: [DictMixin],
    dicts: ['process'],
    props: {
      row: Object
    },
    data(){
      return {
        title: '管理员审核',
        open: false,
        form:{}
      }
    },
    created(){

    },
    methods: {
      cancelForm(){
        this.open=false
        if(this.$refs['form']){
          this.$refs['form'].resetFields()
        }
        //清空数据
        this.form={}
      },
      submitForm(){
        this.$refs['form'].validate((valid) => {
          console.log(valid)
           if (valid) {
              this.executeProcess()
           }
        })
      },
      executeProcess(){
        this.$confirm('确定提交数据吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {

         //整合后台需要的数据
           const data= {
             tenantId: this.form.id,
             description: this.form.description,
             status: this.form.status
           }

           //ajax发请求
           processApi(data).then(resp=>{
               //通知父组件刷新页面
               this.$emit('myrefresh')
               this.cancelForm()
             })           

        }).catch(() => {
        })

      }
    },
    watch:{
      'row'(newValue,oldValue){
          this.form = Object.assign({}, this.form,newValue)
          this.$set(this.form,'status',undefined)
          this.open=true
      }
    }
  }
</script>

<style>
</style>
