package com.yuraloga.ecarservice.service.impl;

import com.yuraloga.ecarservice.dao.PhotoSetDao;
import com.yuraloga.ecarservice.exceptions.NotFoundException;
import com.yuraloga.ecarservice.model.PhotoSet;
import com.yuraloga.ecarservice.service.PhotoSetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class PhotoSetServiceImpl implements PhotoSetService {
    private static final String PHOTOSET_WAS_NOT_FOUND_MESSAGE = "PhotoSet was not found";

    private final PhotoSetDao photoSetDao;

    @Transactional(readOnly = true)
    @Override
    public PhotoSet getPhotoSetById(int id) {
        log.debug("Finding photoSet by id: {}", id);
        return photoSetDao.findById(id)
                .orElseThrow(() -> new NotFoundException(PHOTOSET_WAS_NOT_FOUND_MESSAGE));
    }
}
