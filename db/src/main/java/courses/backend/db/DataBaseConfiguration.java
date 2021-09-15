package courses.backend.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {
  "courses.backend.db.entity",
  "courses.backend.db.converter"
})
@EnableJpaRepositories(basePackages = "courses.backend.db.repository")
@EnableTransactionManagement
public class DataBaseConfiguration {
}
