package com.innei.digital.controller;

import com.innei.digital.entity.Type;
import com.innei.digital.service.TypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController()
@RequestMapping(path = "/types")
@Api(tags = "Type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Type> getTypes(
            @RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = true, defaultValue = "10") Integer size) {
        return this.typeService.listType(page, size);
    }

    @RequestMapping(path = "/all")
    public Iterable<Type> getAllTypes() {
        return this.typeService.listAll();
    }


    @GetMapping(path = "/{id}")
    public Type getType(@PathVariable("id") Integer id) {
        var t = this.typeService.getById(id);
        if (t.isEmpty()) {
            return null;
        }
        return t.get();
    }

    @PostMapping(path = "")
    public Type createType(@RequestBody @Valid Type type) {
        return this.typeService.createType(type);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateType(@RequestBody @Valid Type type, @PathVariable("id") Integer id) {
        var _id = type.getId();
        if (_id == null) {
            type.setId(id);
        }
        var res = this.typeService.updateType(type);
        if (!res) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "修改失败");
        }

    }

    @DeleteMapping(path = "/{id}")
    public void deleteType(@PathVariable("id") Integer id) {
        var res = this.typeService.deleteType(id);
        if (!res) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "删除失败");
        }

    }
}
