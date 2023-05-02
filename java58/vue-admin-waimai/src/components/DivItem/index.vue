<template>
  <div class="dishitem" :class="{'active': active }">
    <div class="value">
     <span class="content">{{value}}</span>
    </div>
    <div class="money" :class="{'show':showMoney}">
      <span class="content">￥{{money}}</span>
    </div>
  </div>
</template>

<script>
  export default{
    props:{
      value: String,
      money: Number,
      active: false
    },
    computed:{
      showMoney(){ 
        if(this.money) {
          return true
        }else{
          return false
        }
      }
    }
  }
</script>

<style scoped="scoped">

.dishitem{
  line-height:20px;
  display: inline-block;
  border-radius: 5px;
  border: 1px solid #c1c3d0;
  margin-right: 5px;
}

.dishitem .value{
  float: left;
}

.dishitem .money{
  float: left;
  border-left: 1px solid #c1c3d0;
  color: #db6159;
  display: none;
}


.dishitem .show{
  display: block
}

.dishitem .content{
  padding: 8px;
  display: inline-block;
}

.dishitem.active{
  background-color: #fffbf0;
   border: 1px solid #e6b63c;
}

.dishitem.active .value{
  color: #e6b63c;
}
.dishitem.active .money{
  float: left;
  border-left: 1px solid #e6b63c;
}
</style>
