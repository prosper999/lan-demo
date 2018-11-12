package etg.lan.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("sys_lan_basic")
public class SysLanBasic {

    @TableId
    private String id;
    @TableField("table_name")
    private String tableName;
    @TableField("table_name_desc")
    private String tableNameDesc;
    @TableField("column_name")
    private String columnName;
    @TableField("column_name_desc")
    private String columnNameDesc;
    @TableField("used")
    private Boolean used;

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableNameDesc() {
        return tableNameDesc;
    }

    public void setTableNameDesc(String tableNameDesc) {
        this.tableNameDesc = tableNameDesc;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnNameDesc() {
        return columnNameDesc;
    }

    public void setColumnNameDesc(String columnNameDesc) {
        this.columnNameDesc = columnNameDesc;
    }
}
