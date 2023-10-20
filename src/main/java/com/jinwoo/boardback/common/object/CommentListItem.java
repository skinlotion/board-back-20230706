package com.jinwoo.boardback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.jinwoo.boardback.repository.resultSet.CommentListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentListItem {
    private String nickName;
    private String profileImage;
    private String writeDatetime;
    private String content;

    public CommentListItem(CommentListResultSet resultSet) {
        this.nickName = resultSet.getNickname();
        this.content = resultSet.getContent();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.profileImage = resultSet.getProfileImage();
    }

    public static List<CommentListItem> getList(List<CommentListResultSet> resultSets) {
        List<CommentListItem> list = new ArrayList<>();
        for (CommentListResultSet resultSet : resultSets) {
            CommentListItem commentListItem = new CommentListItem(resultSet);
            list.add(commentListItem);
        }
        return list;
    }
}
