package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("Polirom", "Copou street 1", "Iasi", "Iasi", "707070");


        Author eric = new Author("Eric", "Evans" );
        Book ddd = new Book("Domain driven design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisher.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "393945459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Publisher: " + publisher.getName() + " has " + publisher.getBooks().size() + " in print books");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
