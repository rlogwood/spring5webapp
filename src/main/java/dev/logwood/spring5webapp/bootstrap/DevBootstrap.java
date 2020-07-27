package dev.logwood.spring5webapp.bootstrap;

import dev.logwood.spring5webapp.model.Author;
import dev.logwood.spring5webapp.model.Book;
import dev.logwood.spring5webapp.model.Publisher;
import dev.logwood.spring5webapp.repositories.AuthorRepository;
import dev.logwood.spring5webapp.repositories.BookRepository;
import dev.logwood.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Publisher pub1 = new Publisher("The Pub 1", "1 Right Way", "New York", "NY", "10001");
        publisherRepository.save(pub1);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub1);
        pub1.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub1);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub1);;
        pub1.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub1);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of Authors:" + authorRepository.count());
        System.out.println("Number of Publishers:" + publisherRepository.count());
        System.out.println("Publisher number of books:" + pub1.getBooks().size());

    }
}
