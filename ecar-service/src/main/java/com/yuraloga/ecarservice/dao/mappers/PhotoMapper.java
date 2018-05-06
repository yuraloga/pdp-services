package com.yuraloga.ecarservice.dao.mappers;

import com.yuraloga.ecarservice.model.Photo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yura on 4/8/17.
 */
public class PhotoMapper {
    private PhotoMapper() {
        throw new UnsupportedOperationException();
    }

    public static Photo mapResultSet(ResultSet resultSet, int rowNum) throws SQLException {
        return new Photo(
                resultSet.getInt("id"),
                resultSet.getInt("photoset_id"),
                resultSet.getString("name"),
                resultSet.getBlob("content"),
                resultSet.getString("image_url")
        );
    }
}
