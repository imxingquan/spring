
## 使用Spring boot 创建应用程序

```
spring init -dweb,data-jpa,h2,thymeleaf --build gradle  readinglist
```

## 构建并应用程序  

    gradle bootRun

先构建后运行 

    gradle build 
    java -jar build/libs/reading-0.0.1-SNAPSHOT.jar

## 业务逻辑示例

我们创建的一个图书目录，根据作者名字来列出属于作者的图书目录，还可以为作者添加图书

### 定义领域模型 

列表里的书(Book)模型
```java
@Entity
public class Book{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String reader;
    private String isbn;
    private String title;
    private String author;
    private String description;
    ...
}
```
### 定义仓库接口

定义一个扩展自JpaRepository的接口,增加一个根据作者名称来查阅图书目录

```java
public interface ReadingListRepository extends JpaRepository<Book,Long> {

    List<Book> findByReader(String reader);
    
}
```
通过继承JpaRepository接口实现了对领域对象Book的持久化操作。

### 创建Web界面

创建SpringMVC控制器

```java
@Controller
@RequestMapping("/")
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value="/{reader}",method= RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader,
                               Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);

        if(readingList != null){
            model.addAttribute("books",readingList);
        }
        return "readinglist";
    }

    @RequestMapping(value="/{reader}",method=RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader,
                                   Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
```
readerBooks 处理/{reader}的GET请求，获取book的列表。
addToReadingList() 处理/{reader}的POST请求



创建resource\template\readinglist.html thymeleaf模板文件
创建resources\static\style.css
构建并运行 gradle bootRun

