<template>
<div>
  <el-table
    :data="tableData.slice((pages.currentPage-1)*pages.size,pages.currentPage*pages.size)"
    height=""
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
          @click="handleDelete(scope.$index,scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
    <el-dialog title="编辑学生信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-input v-model="form.id" v-show="false"></el-input>
        <el-form-item label="姓名">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="班级">
          <el-input v-model="form.classes"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="handleUpdate()">确 定</el-button>
        <el-button @click="dialogFormVisible = false">取 消</el-button>
      </div>
  </el-dialog>
  <div style="text-align: right">
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-sizes="[5, 10, 15, 20]"
        :page-size=pages.size
        layout="total, sizes, prev, pager, next"
        :total=pages.total>
    </el-pagination>
  </div>

</div>
</template>

<script>
import { show,deleted,update } from "@/api/student.js";
  export default {
   data() {
      return {
        dialogFormVisible: false,
        tableData: [],
        pages:{
          total: 0,
          size: 5,
          currentPage: 1,
        },
        form: {
          id:'',
          name: '',
          classes: '',
          phone: '',
        },
        index: "",
      }
    },
    //生命周期函数（渲染组件时）
    mounted: function(){
      this.loadData()
    },
    methods: {
    loadData(){
      show().then((response)=>{
      this.tableData = response.data.data;
      this.pages.total = response.data.data.length
      })
    },
    // 把当前的行对象row传入
    handleEdit(row) {
      this.form.id = row.id
      this.form.name = row.name
      this.form.classes = row.classes
      this.form.phone = row.phone
      this.dialogFormVisible = true;
      },
    handleUpdate(){
      update(this.form).then(
        response => {
        this.dialogFormVisible = false;
        this.loadData()
        this.$message({
          message: '更新成功',
          type: 'success'
        })})
      },
    handleDelete(index,row) {
        //删除记录
        var id = row.id
        this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleted(id).then(
            response => {
              /*splice () 方法通过删除或替换现有元素或者原地添加新的元素来修改数组，并以数组形式返回被修改的内容。 */
              this.tableData.splice(index,1);
              this.$message({
                  message: "成功删除",
                  type: 'success'
                });
            }
          )
         }).catch(() => {
           this.$message({
             type: 'info',
             message: '已取消删除'
           });
         });
      },
    handleSizeChange(val) {
      this.pages.size = val;
    },
    handleCurrentChange(val) {
      this.pages.currentPage = val;
    }
  }
}
</script>



