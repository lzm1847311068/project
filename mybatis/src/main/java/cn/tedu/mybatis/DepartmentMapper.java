package cn.tedu.mybatis;

public interface DepartmentMapper {

    /*
    以后写代码，要先评估一下返回值是一个还是一个list，如果可能查出多个结果，
    必须配置resultMap
     */
    DepartmentVO findById(Integer id);
}
