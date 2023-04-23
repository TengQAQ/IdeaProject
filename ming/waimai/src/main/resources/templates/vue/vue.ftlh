<template>
    <div class="app-container">

        <#if searchParams??>
        <!-- 搜索区 -->
        <el-form :model="queryParam" ref="queryForm" size="small" :inline="true">

             <#list searchParams as params>
            <el-form-item label="${params.comments}" prop="${params.javaField}">
                <el-input v-model="queryParam.${params.javaField}" placeholder="请输入${params.comments}" clearable style="width: 240px"
                          @keyup.enter.native="handleQuery" />
            </el-form-item>
            </#list>

            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            </el-form-item>
        </el-form>

        </#if>

        <!--功能区-->
        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button
                        type="primary"
                        plain
                        icon="el-icon-plus"
                        size="mini"
                        @click="handleAdd()"
                >新增</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                        type="success"
                        plain
                        icon="el-icon-edit"
                        size="mini"
                        :disabled="single"
                        @click="handleUpdate()"
                >修改</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                        type="danger"
                        plain
                        icon="el-icon-delete"
                        size="mini"
                        :disabled="multiple"
                        @click="handleDelete()"
                >删除</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                        type="warning"
                        plain
                        icon="el-icon-download"
                        size="mini"
                        @click="handleExcel()"
                >导出</el-button>
            </el-col>
        </el-row>


        <el-table :data="tableData.rows" border style="width: 100%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <#list  tableFieldList as column>
                 <#if column.vueType==2 >
                     <el-table-column label="${column.comments}" width="220">
                         <template slot-scope="scope">
                             <img :src="scope.row.${column.javaField}" width="150">
                         </template>
                     </el-table-column>
                 <#else >
                     <el-table-column prop="${column.javaField}" label="${column.comments}"   />
                 </#if>
            </#list>

            <el-table-column label="操作" align="center"  class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit"   v-shop @click="handleUpdate(scope.row)" >修改</el-button>
                    <el-button size="mini" type="text" icon="el-icon-delete" v-shop @click="handleDelete(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>


        <!-- 分页条 -->
        <el-pagination v-if="tableData.total>0" :current-page="queryParam.page" :page-sizes="[1, 5, 10, 20,30,50,100]"
                       :page-size="queryParam.size" layout="total, sizes, prev, pager, next, jumper" :total="tableData.total"
                       @size-change="handleSizeChange" @current-change="handleCurrentChange" />


        <!-- 新增和修改对话框-->
        <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body :close-on-click-modal="false" :before-close="cancelForm">
            <el-form ref="form" :model="form"   label-width="100px">

                <#list  tableFieldList as column>

                     <#if column.vueType==2 >
                         <el-form-item label="${column.comments}" prop="${column.javaField}" :rules="[  { required: true, message: '该值不能为空', trigger: 'blur' }]">
                             <el-upload
                                     class="avatar-uploader"
                                     :action="imageUploadUrl"
                                     :headers="headers"
                                     :show-file-list="false"
                                     :on-success="handleAvatarSuccess"
                                     :before-upload="beforeAvatarUpload">
                                 <img v-if="form.${column.javaField}" :src="form.${column.javaField}" class="avatar">
                                 <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                             </el-upload>
                         </el-form-item>
                     <#else>
                         <el-form-item   label="${column.comments}" prop="${column.javaField}"  :rules="[  { required: true, message: '该值不能为空', trigger: 'blur' }]">
                             <el-input v-model="form.${column.javaField}" placeholder="请输入${column.comments}"  />
                         </el-form-item>

                     </#if>
                </#list>

            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitForm">确 定</el-button>
                <el-button @click="cancelForm">取 消</el-button>
            </div>
        </el-dialog>


    </div>
</template>

<script>
    import PageMixin from '@/mixins/PageMixin.js'
    import AddOrEditMixin from '@/mixins/AddOrEditMixin.js'
    import DictMixin from '@/mixins/DictMixin.js'
    import {dataApi, addApi, editApi, findByIdApi, downloadExcel} from '@/api/${entityName?lower_case}.js'
    export default {
        mixins: [DictMixin,PageMixin, AddOrEditMixin],
        dicts: [],
        data() {
            return {
                // 查询函数
                fetchDataApi: dataApi,
                // 新增函数
                addApi: addApi,
                // 新增函数
                editApi: editApi,
                // 新增函数
                findByIdApi: findByIdApi,
                primaryKey: '${primaryKey}',
                //头像放到表单哪个字段里面
                <#if uploadField??>
                uploadField: '${uploadField}'
                </#if>
            }
        },
        methods: {
            // 重置表单
            initFormValue(){
                // 头像必须要有定义
                this.form= {
                    <#if uploadField??>
                    ${uploadField}: undefined
                    </#if>
                }
            },
            handleExcel(){
                this.download('/api/${entityName?lower_case}/download',this.queryParam,'${entityName?lower_case}_data.xlsx')
            }

        },
        created(){
            this.initFormValue()
        }

    }
</script>

<style>
</style>
