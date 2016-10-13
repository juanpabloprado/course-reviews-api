package com.juanpabloprado.core;

import com.juanpabloprado.course.Course;
import com.juanpabloprado.course.CourseRepository;
import com.juanpabloprado.review.Review;
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
    String[] templates = {
        "Up and running with %s",
        "%s Basics",
        "%s for Beginners",
        "%s for Neckbeards",
        "Under the hood: %s"
    };
    courses.save(course);
  }
}
