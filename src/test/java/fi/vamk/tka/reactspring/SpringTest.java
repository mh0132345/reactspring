package fi.vamk.tka.reactspring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import fi.vamk.tka.reactspring.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackageClasses = GroupRepository.class)
public class SpringTest{
    @Autowired
    private GroupRepository repository;
    @Test
    public void addingGroupTest(){
        Group mygroup = new Group();
        mygroup.setName("Vaasa JUG");
        repository.save(mygroup);

        Group found = repository.findByName(mygroup.getName());
        assertEquals(found.getName(), mygroup.getName());
		repository.delete(found);   
    }
    
    @Test
    public void springTest(){
        System.out.println("Is it already spring?");
    }
}