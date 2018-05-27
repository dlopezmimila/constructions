package com.dlm.constructions.service.impl;

import com.dlm.constructions.model.Construction;
import com.dlm.constructions.repository.ConstructionRepository;
import com.dlm.constructions.service.ContructionService;
import com.dlm.constructions.views.ConstructionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ConstructionServiceImpl implements ContructionService {
    private ConstructionRepository constructionRepository;
    @Autowired
    public void setConstructionRepository(ConstructionRepository constructionRepository) {
        this.constructionRepository = constructionRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public void addConstruction(ConstructionView view) {
        constructionRepository.save(fromView(view));
    }

    @Override
    public ConstructionView findById(Long id) {
        return fromEntity(constructionRepository.getOne(id));
    }

    @Override
    public List<ConstructionView> searchContructions(Long rowVersion) {
        if(rowVersion==null){
            return constructionRepository.findAll().stream()
                    .map(s->fromEntity(s))
                    .collect(Collectors.toList());
        }else{
            Specification<Construction> constructionSpecification=Specification.where((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("rowVersion"),new Date(rowVersion))
            );
            List<Construction> list = constructionRepository.findAll(constructionSpecification);
            return list.stream()
                    .map(s->fromEntity(s))
                    .collect(Collectors.toList());

        }

    }

    @Override @Transactional
    public void deleteConstruction(Long id) {
    constructionRepository.deleteById(id);
    }



    @Override
    public void updateConstruction(ConstructionView view) {
        constructionRepository.save(fromView(view));

    }

    private Construction fromView(ConstructionView view){
      Construction construction= new Construction();
      construction.setIdType(view.getIdType());
      construction.setName(view.getName());
      construction.setRowVersion(new Date());
      return construction;
    }

    private ConstructionView fromEntity(Construction construction) {
        ConstructionView view= new ConstructionView();
        view.setIdType(construction.getIdType());
        view.setName(construction.getName());
        view.setRowVersion(new Date());
        return view;

    }


}