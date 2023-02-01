<template>
  <el-form ref="form" :model="form" label-width="80px" style="width:50%;margin-top:20px" >
    <el-form-item label="姓名">
      <el-input v-model="form.name"></el-input>
    </el-form-item>
    <el-form-item label="班级">
      <el-input v-model="form.classes"></el-input>
    </el-form-item>
    <el-form-item label="电话">
      <el-input v-model="form.phone"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit()">添加</el-button>
      <el-button @click="reform()">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import {insert} from "@/api/student.js";

export default {
  data() {
      return {
        form: {
          name: '',
          classes: '',
          phone: '',
        },
      }
    },
  methods: {
      onSubmit() {
        //提交添加请求
        if(this.form.name.length < 1 ||
          this.form.classes.length < 1 ||
          this.form.phone.length < 1 
         ){
           this.$message({
             message: "请填写完整的信息",
             type: "error"
           })
         }else{

           insert(this.form).then(
            response=>{
            this.$message({
             message:'添加成功',
             type: "success"
             })
             })
           }
         },
      reform(){
      this.form.name = ""
      this.form.classes = ""
      this.form.phone = ""
        },
      },
}
</script>