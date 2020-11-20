package com.gloryh.controller;

import com.gloryh.entity.Menu;
import com.gloryh.entity.MenuVO;
import com.gloryh.entity.Type;
import com.gloryh.repository.MenuRepository;
import com.gloryh.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * menu controller
 *
 * @author 黄光辉
 * @since 2020/10/27
 **/
@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        // 获取所有列表
        List<Menu> menus = menuRepository.findAll(index, limit);
        //获取总数
        int count = menuRepository.count();
        return new MenuVO(0, "", count, menus);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        menuRepository.deleteById(id);
    }

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/findTypes")
    public List<Type> findTypes() {
        return typeRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuRepository.findById(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }

}
