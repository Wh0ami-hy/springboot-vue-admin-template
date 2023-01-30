<template>
  <el-form :model="tableData" label-width="80px" style="width:50%;margin-top:20px" >
    <el-form-item label="姓名">
      <el-input v-model="tableData.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="班级">
      <el-input v-model="tableData.classes" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="电话">
      <el-input v-model="tableData.phone" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">添加</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data() {
      return {
        dialogFormVisible: false,
        tableData: [{
          id: '1',
          phone: '123132',
          name: '王小虎',
          classes: '459'
        }, {
          id: '2',
          phone: '888888',
          name: '王大虎',
          classes: '460'
        }]
      }
    },
  methods: {
      onSubmit() {
        //提交添加请求
        var name = this.tableDate.name;
        var classes = this.tableData.class;
        var phone = this.tableData.phone;
        if(null === name || "" === name ||
           null === classes || "" === classes ||
           null === phone || "" === phone 
         ){
           this.$message({
             message: "请填写完整的信息",
             type: "error"
           })
         }else{
           
           }
         }
      },
  }
</script>