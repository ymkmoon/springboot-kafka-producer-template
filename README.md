# springboot-kafka-producer-template

MQTT Subscriber (MQTT 메세지 구독) + Kafka producer (Kafka = 메세지 발행)

MQTT Publisher -> MQTT Broker -> **Kafka producer (+MQTT Subscriber)** -> Kafka Broker -> Consumer

- MQTT Publisher : 추가예정
- MQTT Broker : 추가예정
- Kafka producer : https://github.com/ymkmoon/springboot-kafka-producer-template
- Kafka Broker : https://github.com/ymkmoon/kafka-template
- Consumer : https://github.com/ymkmoon/springboot-consumer-template



## 주요 기술 스택

- **Java**: 17
- **Spring Boot**: 3.2.5
- **Gradle**: 8.2

---

## 프로젝트 구조

```
springboot-kafka-producer-template
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com.example.template
│  │  │      ├─ config         # 설정 파일 (DB, Redis, Security 등)
│  │  │      ├─ common         # 공통 클래스 (헬스체크, ...)
│  │  │      ├─ aop            # AOP 로그 관련 
│  │  │      ├─ model          # Producer Entity (IOT 수집 데이터 관련)
│  │  │      └─ util           # 유틸리티 클래스
│  │  │      └─ constants      # 상수 클래스
│  │  │      └─ sample         # 예제 (Service, Repository)
│  │  │      └─ ...            
│  │  └─ resources
│  │      ├─ application.yml
│  │      ├─ application-local.yml
│  │      ├─ application-dev.yml
└─ build.gradle
```

---

## 빌드

### 1. 프로젝트 루트 경로 이동

### 2. Gradle Wrapper 설정 (최초 빌드 시)

```bash
./gradlew wrapper --gradle-version 8.2
```

### 3. 프로젝트 빌드

- **맥북**:

```bash
./gradlew clean build
```

- **윈도우**:

```bash
gradlew clean build
```

---

## Spring 프로파일별 설정

> `application-local.yml` / `application-dev.yml` 참고


