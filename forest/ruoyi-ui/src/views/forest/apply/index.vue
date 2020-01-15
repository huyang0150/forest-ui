<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="开始时间" prop="startDate">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.startDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结束时间" prop="endDate">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.endDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="结束时间">
       </el-date-picker>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
    
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['forest:apply:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="receiverName">
          <el-input v-model="form.receiverName" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="receiverIdCardNo">
          <el-input v-model="form.receiverIdCardNo" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="receiverContactPhone">
          <el-input v-model="form.receiverContactPhone" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="receiverProvinceCode">
          <el-input v-model="form.receiverProvinceCode" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="receiverCityCode">
          <el-input v-model="form.receiverCityCode" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="receiverDistrictCode">
          <el-input v-model="form.receiverDistrictCode" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="receiverAddress">
          <el-input v-model="form.receiverAddress" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}">
          <el-select v-model="form.commodityType" placeholder="请选择${comment}">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="${comment}">
          <el-select v-model="form.firstMonthTariffType" placeholder="请选择${comment}">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="${comment}" prop="networkAccessIdCardName">
          <el-input v-model="form.networkAccessIdCardName" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="networkAccessIdCardNo">
          <el-input v-model="form.networkAccessIdCardNo" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="orderPhone">
          <el-input v-model="form.orderPhone" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="gmtCreated">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.gmtCreated"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listApply, getApply, delApply, addApply, updateApply, exportApply } from "@/api/forest/apply";

export default {
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 总条数
      total: 0,
      // 【请填写功能名称】表格数据
      applyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        receiverName: undefined,
        receiverIdCardNo: undefined,
        receiverContactPhone: undefined,
        receiverProvinceCode: undefined,
        receiverCityCode: undefined,
        receiverDistrictCode: undefined,
        receiverAddress: undefined,
        commodityType: undefined,
        firstMonthTariffType: undefined,
        networkAccessIdCardName: undefined,
        networkAccessIdCardNo: undefined,
        orderPhone: undefined,
        gmtCreated: undefined,
        status: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        gmtCreated: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],        status: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ]      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listApply(this.queryParams).then(response => {
        this.applyList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        orderNo: undefined,
        receiverName: undefined,
        receiverIdCardNo: undefined,
        receiverContactPhone: undefined,
        receiverProvinceCode: undefined,
        receiverCityCode: undefined,
        receiverDistrictCode: undefined,
        receiverAddress: undefined,
        commodityType: undefined,
        firstMonthTariffType: undefined,
        networkAccessIdCardName: undefined,
        networkAccessIdCardNo: undefined,
        orderPhone: undefined,
        gmtCreated: undefined,
        status: "0"
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.orderNo)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加【请填写功能名称】";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const orderNo = row.orderNo || this.ids
      getApply(orderNo).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.orderNo != undefined) {
            updateApply(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          } else {
            addApply(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const orderNos = row.orderNo || this.ids;
      this.$confirm('是否确认删除【请填写功能名称】编号为"' + orderNos + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delApply(orderNos);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有【请填写功能名称】数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportApply(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>