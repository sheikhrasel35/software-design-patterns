public interface BookGenre {
List<Book> getBookList();
}

public class Fiction implements BookGenre {
...
}
public class NonFiction implements BookGenre {
...
}
public class Technology implements BookGenre {
...
}

public enum BookType { FICTION, NONFICTION,
TECHNOLOGY }
public class LibraryService {
   private BookGenre fiction;
   private BookGenre nonFiction;
   private BookGenre technology;
   public LibraryService() {
       this.fiction = new Fiction();
       this.nonFiction = new NonFiction();
       this.technology = new Technology();
   }
public void borrowBook(BookType type, String name)
{
       List<Book> books;
       switch(type) {
           case FICTION: books =
this.fiction.getBookList();
         break;
           case NONFICTION: books =
this.nonFiction.getBookList();
        break;
           default: books =
this.technology.getBookList();
       }
       Book book =
BookService.findBookByName(books, name);
       book.setAvailability(false);
   }
  ...
}
