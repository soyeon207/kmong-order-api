> API 및 DB 는 아래 노션을 확인해주세요.
https://cottony-orca-c64.notion.site/dfb597a762da4df9a35d12a6e99d9ace

## 실행 방법
### ① docker-compose 실행
> 💡 Docker Desktop 을 실행하고 진행해주세요.
> 없으신 경우  [Docker Desktop](https://www.docker.com/products/docker-desktop/) 에서 다운받아주시면 됩니다.

```
docker-compose -p kmong up -d
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

