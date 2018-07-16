package com.yuraloga.ecarservice.service.impl;

import com.yuraloga.ecarservice.dao.PhotoDao;
import com.yuraloga.ecarservice.exceptions.NotFoundException;
import com.yuraloga.ecarservice.model.Photo;
import com.yuraloga.ecarservice.service.PhotoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private static final String PHOTO_WAS_NOT_FOUND_MESSAGE = "Photo was not found";

    private final PhotoDao photoDao;

    @Transactional(readOnly = true)
    @Override
    public Photo getPhotoById(int id) {
        log.debug("Finding photo by id: {}", id);
        return photoDao.findById(id)
                .orElseThrow(() -> new NotFoundException(PHOTO_WAS_NOT_FOUND_MESSAGE));
    }
}
