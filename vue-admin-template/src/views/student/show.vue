<template>
<div>
  <el-table
    :data="tableData"
    height="250"
    border
    style="width: 100%">
      <el-table-column
        label="姓名"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column
        label="班级"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.classes }}
        </template>
      </el-table-column>
      <el-table-column
        label="电话"
        width=""
        align="center">
          <template slot-scope="scope">
            {{ scope.row.phone }}
        </template>
      </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="primary"
          @click="handleEdit(scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
    <el-dialog title="编辑学生信息" :visible.sync="dialogFormVisible">
      <el-form :model="tableData">
        <el-form-item label="姓名">
          <el-input v-model="tableData.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="班级">
          <el-input v-model="tableData.classes" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="tableData.phone" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleUpdateStudent()">确 定</el-button>
      </div>
  </el-dialog>



</div>
</template>

<script>
import { show } from "@/api/student.js";
  export default {
   data() {
      return {
        dialogFormVisible: false,
        tableData: []
      }
    },
    //生命周期函数（被创建时）
    created: function(){
      show().then((response)=>{
        this.tableData = response.data.data;
      })
    },
    methods: {
    handleEdit(row) {
      this.tableData.name = row.name
      this.tableData.classes = row.classes
      this.tableData.phone = row.phone
      this.dialogFormVisible = true;
      },
    handleDelete(row) {
        //删除记录
        var id = row.id;
        this.$confirm('此操作将永久删除该条数据, 是否继续?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
        })
      },
    handleUpdateStudent(){
      this.dialogFormVisible = false;
      },
  }

}
</script>



