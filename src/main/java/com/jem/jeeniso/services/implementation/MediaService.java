package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.ExternalManagerDto;
import com.jem.jeeniso.dto.MarketingManagerDto;
import com.jem.jeeniso.dto.MediaDto;
import com.jem.jeeniso.dto.MeetingDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.ExternalManager;
import com.jem.jeeniso.model.JuniorEntreprise;
import com.jem.jeeniso.model.MarketingManager;
import com.jem.jeeniso.model.Media;
import com.jem.jeeniso.repository.IExternalManagerRepository;
import com.jem.jeeniso.repository.IMarketingManagerRepository;
import com.jem.jeeniso.repository.IMediaRepository;
import com.jem.jeeniso.services.IMediaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.MEDIA_ALREADY_EXISTS;
import static com.jem.jeeniso.exception.ErrorMessages.MEDIA_NOT_FOUND_BY_NAME;

@Service
public class MediaService implements IMediaService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IMediaRepository repository;

    @Autowired
    private IMarketingManagerRepository marketingManagerRepository ;

    @Autowired
    private IExternalManagerRepository externalManagerRepository ;
    @Override
    public MediaDto save(MediaDto dto) {

        boolean isExist = repository.existsByName(dto.getName());
        if (isExist) {
            throw new InvalidOperationException(MEDIA_ALREADY_EXISTS);
        }
        Optional<MarketingManager> optionalMarketingManager = marketingManagerRepository.findByEmail(dto.getMarketingManager().getEmail());

        MarketingManager marketing = optionalMarketingManager.get();

        Optional<ExternalManager> optionalExternalManager = externalManagerRepository.findByEmail(dto.getExternalManager().getEmail());

        ExternalManager extern = optionalExternalManager.get();
        Media media = repository.save(
                Media.builder()
                        .email(dto.getEmail())
                        .name(dto.getName())
                        .phoneNumber(dto.getPhoneNumber())
                        .marketingManager(marketing)
                        .externalManager(extern)
                        .address(dto.getAddress())
                        .build()
        );
        return MediaDto.builder()
                .email(media.getEmail())
                .phoneNumber(media.getPhoneNumber())
                .name(media.getName())
                .marketingManager(modelMapper.map(media.getMarketingManager(), MarketingManagerDto.class))
                .externalManager(modelMapper.map(media.getExternalManager(), ExternalManagerDto.class))
                .address(media.getAddress())
                .build();
    }


    @Override
    public List<MediaDto> findAll() {
        return repository.findAll().stream()
                .map((media-> modelMapper
                        .map(media, MediaDto.class)))
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        MediaDto dto = findById(id);
        if (dto == null) {
            throw new EntityNotFoundException("MEDIA_NOT_FOUND_BY_ID :"+ id);
        }
        repository.deleteById(id);
    }

    @Override
    public void update(Integer id, String name, String email, String phoneNumber,String address) {

        Optional<Media> mediaDto = repository.findById(id);
        System.out.println(name);

        if (!mediaDto.isPresent()) {
            throw new InvalidOperationException("this media is already empty-_-");
        }

        Media media = mediaDto.get();
        media.setName(name);
        media.setAddress(address);
        media.setEmail(email);
        media.setPhoneNumber(phoneNumber);

        repository.save(media);

    }


    @Override
    public MediaDto findById(Integer id) {
        return repository.findById(id).map((media -> modelMapper.map(media, MediaDto.class))).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );
    }


}
