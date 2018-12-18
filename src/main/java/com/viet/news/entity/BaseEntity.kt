package com.viet.news.entity

import com.alibaba.fastjson.annotation.JSONField
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

import javax.persistence.*
import java.io.Serializable
import java.util.Date

/**
 * Created by wangdingzhong on 2018/1/19.
 */
@Data
@MappedSuperclass
@ApiModel(value = "基础实体")
open class BaseEntity : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键")
    open var id: Long? = null

    @Column(name = "create_date_time", nullable = false, updatable = false)
    //@JsonIgnore
    //@JSONField(serialize = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @ApiModelProperty(value = "创建时间")
    var createDateTime: Date? = null

    @Column(name = "update_date_time", nullable = false)
    //    @JsonIgnore
    //    @JSONField(serialize = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @ApiModelProperty(value = "最后更新时间")
    var updateDateTime: Date? = null

    @Column(name = "deleted", nullable = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "删除状态")
    open var isDeleted = false

    @Column(name = "version")
    @JSONField(name = "version")
    @JsonProperty("version")
    @Version
    @ApiModelProperty(value = "版本号")
    var version: Long? = null

    companion object {
        private const val serialVersionUID = -1L
    }

}
