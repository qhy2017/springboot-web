package com.example.demo.service.mapper;

import com.example.demo.model.Ttest;
import com.example.demo.model.TtestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TtestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    int countByExample(TtestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    int deleteByExample(TtestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    int insert(Ttest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    int insertSelective(Ttest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    List<Ttest> selectByExampleWithRowbounds(TtestExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    List<Ttest> selectByExample(TtestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    Ttest selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Ttest record, @Param("example") TtestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Ttest record, @Param("example") TtestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Ttest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_test
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Ttest record);
}