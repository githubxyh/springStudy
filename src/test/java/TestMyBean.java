import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestMyBean {

    @Test
    public void testSimpleLoad(){
        Resource resource = new ClassPathResource("spring-config.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        BeanDefinitionReader bdr = new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
        bdr.loadBeanDefinitions(resource);
        MyBean myBean = (MyBean) bf.getBean("myTestBean");
        System.out.println(myBean.getTestStr());
    }
}
