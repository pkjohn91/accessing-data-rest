package com.example.accessingdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
/*
 * 객체와 관련된 다양한 작업을 수행할 수 있는 Person 객체를 포함하는 인터페이스이다.
 * Spring Data Commons에 정의된 PagingAndSortingRepository 인터페이스를 확장하여 작업을 수행한다.
 * 런타임 시, Spring Data REST는 자동으로 이 인터페이스의 구현을 생성한다. 그런 다음
 * @RepositoryRestResource 주석을 사용하여 Spring MVC로 가리켜 RESTful 끝에 /people을 생성한다.
*/

/*
 * 저장소를 내보내는 데 @RepositoryRestResource가 요구되지 않는다.
 * /people의 기본값을 대신 사용하는 등 내보내기 세부사항을 변경할 때만 사용됩니다.
*/

/*
 * Person 객체는 목록을 검색하는 사용자 지정 쿼리로 정의했다.
 * lastName으로 호출하는 방법을 확인할 수 있다.
*/
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person, Long> {

    List<Person> findByLastName(@Param("name") String name);
}

/*
 * Spring Boot는 Spring Data JPA를 자동으로 가동하여 PersonRepository의 구체적인 구현을 생성하고
 * JPA를 사용하여 백엔드 인메모리 데이터베이스와 통신하도록 구성한다.
 */

/*
 * Spring Data REST는 Spring MVC 위에 구축된다. RESTful 프런트 엔드를 제공하기 위해
 * Spring MVC 컨트롤러, JSON 변환기 및 기타 Bean 컬렉션을 생성한다. 이러한 구성 요소는
 * Data JPA 백엔드에 연결된다. Spring Boot를 사용하면 이 모든 것이 자동으로 구성된다.
 * 이것이 어떻게 작동하는지 조사하려면 RepositoryRestMvcConfiguration Spring Data REST를 보면된다.
 */

/*
 * Spring Data REST는 JSON 출력에 HAL Formmat 방식을 사용한다. 유연하고 제공되는 데이터에 인접한 링크를 제공하는
 * 편리한 방법을 제공한다.
 */