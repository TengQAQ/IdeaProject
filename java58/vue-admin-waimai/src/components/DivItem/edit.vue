<template>
  <div class="dishitemedit"  >
    <div class="value">
     <span class="content">
       <el-input   v-model="item.value" placeholder="名称"></el-input>
     </span>
    </div>
    <div class="money"  >
      <span class="content">￥
       <el-input style="width: 80px;" v-model="item.price" placeholder="价格"></el-input>
      </span>
    </div>
  </div>
</template>

<script>
  export default{
    props:{
     item: Object
    },
    computed:{

    }
  }
</script>

<style scoped="scoped">

.dishitemedit{
  line-height:20px;
  display: inline-block;
  border-radius: 5px;
  margin-right: 5px;
  margin-top: 10px;
}


.dishitemedit .value{
  float: left;
}

.dishitemedit .money{
  float: left;
  color: #db6159;

}


.dishitemedit .content{
  padding: 8px;
  display: inline-block;
}

</style>
