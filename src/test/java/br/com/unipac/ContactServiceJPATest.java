//package br.com.unipac;

import br.com.unipac.protocolo.protocoloapi.modelo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/*@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceJPATest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ContactService contactService;


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testSaveUpdateDeleteContact() throws Exception{
        Contact c = new Contact();
        c.setName("Portgas D. Ace");
        c.setPhone("09012345678");
        c.setEmail("ace@whitebeard.com");

        contactService.save(c);
        assertNotNull(c.getId());

        Contact findContact = contactService.findById(c.getId());
        assertEquals("Portgas D. Ace", findContact.getName());
        assertEquals("ace@whitebeard.com", findContact.getEmail());

        // update record
        c.setEmail("ace@whitebeardpirat.es");
        contactService.update(c);

        // test after update
        findContact = contactService.findById(c.getId());
        assertEquals("ace@whitebeardpirat.es", findContact.getEmail());

        // test delete
        contactService.deleteById(c.getId());

        // query after delete
        exceptionRule.expect(ResourceNotFoundException.class);
        contactService.findById(c.getId());
    }
}*/