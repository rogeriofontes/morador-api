package br.com.unipac.protocolo.protocoloapi.controllers;

import br.com.unipac.protocolo.protocoloapi.exception.BadResourceException;
import br.com.unipac.protocolo.protocoloapi.exception.ResourceAlreadyExistsException;
import br.com.unipac.protocolo.protocoloapi.exception.ResourceNotFoundException;
import br.com.unipac.protocolo.protocoloapi.modelo.domain.Contact;
import br.com.unipac.protocolo.protocoloapi.modelo.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int ROW_PER_PAGE = 10;

    @Autowired
    private ContactService contactService;

    @GetMapping //,@RequestParam(value = "page", defaultValue = "1") int pageNumber
    public String getContacts(Model model, @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<Contact> contacts = contactService.findAll(pageNumber, ROW_PER_PAGE);

        long count = contactService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("contacts", contacts);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        return "contact-list";
    }

    @GetMapping(value = "/{contactId}")
    public String getContactById(Model model, @PathVariable long contactId) throws ResourceNotFoundException {
        Contact contact = contactService.findById(contactId);
        model.addAttribute("contact", contact);
        return "contact";
    }

    @GetMapping(value = "/add")
    public String showAddContact(Model model) throws ResourceNotFoundException {
        model.addAttribute("contact", new Contact());
        model.addAttribute("add", true);
        return "contact-edit";
    }

    @GetMapping(value = "/{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> findContactById(@PathVariable long contactId) {
        try {
            Contact book = contactService.findById(contactId);
            return ResponseEntity.ok(book);  // return 200, with json body
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // return 404, with null body
        }
    }

    /**
     * @PostMapping(value = "/contacts/add")
     * public String addContact(Model model,
     * @ModelAttribute("contact") Contact contact) { ... }
     */

    @PostMapping(value = "/add")
    public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model, RedirectAttributes redirectAttributes)
            throws URISyntaxException, BadResourceException, ResourceAlreadyExistsException {

        if (result.hasErrors()) {
            return "add-student";
        }

        contactService.save(contact);
        redirectAttributes.addFlashAttribute("message", "Dados Cadastrados com sucesso!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/contacts";
    }

    @GetMapping(value = {"/{contactId}/edit"})
    public String showEditContact(Model model, @PathVariable long contactId) throws ResourceNotFoundException {
        Contact contact = contactService.findById(contactId);
        //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("contact", contact);
        model.addAttribute("add", false);
        return "contact-edit";
    }

    @PostMapping(value = "/{contactId}/update")
    public String updateContact(@PathVariable("contactId") long contactId, @Valid Contact contact, BindingResult result,
                                Model model, RedirectAttributes redirectAttributes) throws ResourceNotFoundException, BadResourceException {
        if (result.hasErrors()) {
            Contact contact2 = contactService.findById(contactId);
            //.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
            model.addAttribute("contact", contact2);
            model.addAttribute("add", false);
            return "contact-edit";
        }

        contact.setId(contactId);
        contactService.update(contact);
        redirectAttributes.addFlashAttribute("message", "Dados Alterados com sucesso!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/contacts";

    }

    @GetMapping("/{contactId}/delete")
    public String deleteContact(@PathVariable("contactId") long contactId, RedirectAttributes redirectAttributes) throws ResourceNotFoundException, BadResourceException {
        contactService.deleteById(contactId);
        redirectAttributes.addFlashAttribute("message", "Dados deletados com sucesso!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/contacts";
    }
}
