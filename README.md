> API 및 DB 는 아래 노션을 확인해주세요.
https://cottony-orca-c64.notion.site/dfb597a762da4df9a35d12a6e99d9ace

## 실행 방법
### ① docker-compose 실행
> 💡 Docker Desktop 을 실행하고 진행해주세요.
> 없으신 경우  [Docker Desktop](https://www.docker.com/products/docker-desktop/) 에서 다운받아주시면 됩니다.

```
docker-compose -p order up -d
```

### ② 환경변수 설정하기

configurations > environment variables 에 JWT 관련 environment 키-값을 세팅해주세요.

|Name|Value| 설명      |
|---|---|---------|
|JWT_TOKEN|bWVtYmVyLW9yZGVyLWtleQ==| JWT 토큰  |
|JWT_REFRESH_TIME|1800| 30분     |
|JWT_EXPIRE_TIME|259200| 3일      |

### ③ 실행하기
MemberOrderApiApplication 을 실행해주세요. 

<hr>

## Swagger 사용하기
해당 프로젝트는 Swagger(springdoc-openapi v1.6.9) 을 사용해서 API 문서 자동화를 하고 있습니다.  

swagger 접속 URL : http://localhost:8080/swagger-ui/index.html

회원가입, 로그인 이외 API 들은 JWT 토큰이 있어야 합니다.

1. 오른쪽 상단의 **🔓Authorize** 를 누른다음  
   ![https://user-images.githubusercontent.com/39696812/177332423-9616ead5-77ae-4414-aea1-ecbce562c9f7.png](https://user-images.githubusercontent.com/39696812/177332423-9616ead5-77ae-4414-aea1-ecbce562c9f7.png)
2. 창이 뜨면 로그인 시 발급되는 token 을 입력해주세요.
   ![https://user-images.githubusercontent.com/39696812/177332450-8c28852f-278d-4fa3-82a5-2a2a4b92d124.png](https://user-images.githubusercontent.com/39696812/177332450-8c28852f-278d-4fa3-82a5-2a2a4b92d124.png)

그러면 API 를 호출할 때 헤더에 `Authorization: Bearer #{입력한토큰값}` 을 넣어서 호출합니다.  
