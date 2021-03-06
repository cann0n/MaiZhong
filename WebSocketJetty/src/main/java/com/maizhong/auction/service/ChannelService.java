package com.maizhong.auction.service;

import com.maizhong.auction.dto.AuctionHistoryDTO;
import com.maizhong.auction.pojo.AcBidRecord;

/**
 * Created by Xushd on 2017/6/26.
 */
public interface ChannelService {

    void createAuctionQueue(int chNum);

    void dataSave();
    /**
     * 通道轮询
     * @param ch
     */
    void pollingChannel(String ch);

    void clearChannel(int chNum);

    void addSocketQueue(AcBidRecord acBidRecord);

    void sendSocket();

}
