package com.viet.news.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "person")
public class ChannelList {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;
}
