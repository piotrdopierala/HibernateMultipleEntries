package EmployeesRepo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkillTest {

    @Test
    public void should_compare_string_to_skill() {
        //given
            String sk1_name = new String("skill1");
            Skill sk1 = new Skill(new String("skill1"));
        //when
            boolean shouldTrue = sk1.equals(new String("skill1"));
            boolean shouldFalse = sk1.equals(new String("aaa"));
        //then
            Assert.assertTrue(shouldTrue);
            Assert.assertFalse(shouldFalse);
    }

    @Test
    public void shold_return_name_from_toString() {
        //given
        String sk1_name = "skill1";
        Skill sk1 = new Skill(sk1_name);
        //when
        String toStringResult = sk1.toString();
        //then
        Assert.assertEquals(sk1_name, toStringResult);
    }
}