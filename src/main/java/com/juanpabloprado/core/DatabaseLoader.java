package com.juanpabloprado.core;

import com.juanpabloprado.course.Course;
import com.juanpabloprado.course.CourseRepository;
import com.juanpabloprado.review.Review;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
  private final CourseRepository courses;

  @Autowired
  public DatabaseLoader(CourseRepository courses) {
    this.courses = courses;
  }

  @Override public void run(ApplicationArguments args) throws Exception {
    Course course = new Course("Java Basics", "https://teamtreehouse.com/library/java-basics");
    course.addReview(new Review(3, "You ARE a dork!!!"));
    courses.save(course);

    String[] templates = {
        "Up and running with %s",
        "%s Basics",
        "%s for Beginners",
        "%s for Neckbeards",
        "Under the hood: %s"
    };
    String[] buzzwords = {
        "Spring REST Data",
        "Java 9",
        "Scala",
        "Groovy",
        "Hibernate",
        "Spring HATEOAS"
    };

    List<Course> bunchOfCourses = new ArrayList<>();
    IntStream.range(0, 100)
        .forEach(i -> {
          String template = templates[i % templates.length];
          String buzzword = buzzwords[i % buzzwords.length];
          String title = String.format(template, buzzword);
          Course c = new Course(title, "http://example.com");
          c.addReview(new Review(i % 5, String.format("Moar %s please!!!!", buzzword)));
          bunchOfCourses.add(c);
        });

    courses.save(bunchOfCourses);

  }
}
