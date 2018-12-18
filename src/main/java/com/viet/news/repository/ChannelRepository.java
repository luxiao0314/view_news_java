package com.viet.news.repository;

import com.viet.news.entity.ChannelList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<ChannelList, Long> {

}
