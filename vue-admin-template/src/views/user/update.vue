<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px" style="width:50%;margin-top:20px" >
      <el-form-item label="账号">
        <el-input v-model="form.username" />
      </el-form-item>
    <el-form-item label="密码">
        <el-input v-model="form.password"></el-input>
    </el-form-item>
    <!--上传图片组件action 为接收上传的后端地址-->
    <el-form-item label="头像">
       <el-upload
          class="avatar-uploader"
          action="http://localhost:8888/upload/picture"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
          name = "photo" 
          >
          <!--这个name的值对应后端接收的参数名-->
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
        <el-button @click="onCancel">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {update} from "@/api/user.js";
 
export default {
  data() {
    return {
      imageUrl: '',
      form: {
        username: '',
        password:'',
      },
    }
  },
  methods: {
    onSubmit() {
      if(this.form.username.length < 1 ||
        this.form.password.length < 1
        ){
        this.$message.error("请填写完整的信息")
      }else{
        var data = {
        username: this.form.username,
        password: this.form.password,
      }
      update(data).then(
        response=>{
            this.$message.success("提交成功")
        }
      )
      }
    },
    onCancel() {
      this.form.username = ""
      this.form.password = ""
    },
     handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 5;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 5MB!');
      }
      return isJPG && isLt2M;
      }
  },
  mounted: function() {
    this.form.username = this.$store.getters.name
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
</style>

