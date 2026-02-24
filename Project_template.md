## Изучите [README.md](README.md) файл и структуру проекта.

## Задание 1

[ca-container](diagrams/ca-container.puml)


## Задание 2

### Tests

![tests](task_2/tests.png)

### Topics

![kafka topics](task_2/topics.png)

## Задание 3

Команда начала переезд в Kubernetes для лучшего масштабирования и повышения надежности. 
Вам, как архитектору осталось самое сложное:
 - реализовать CI/CD для сборки прокси сервиса
 - реализовать необходимые конфигурационные файлы для переключения трафика.


### CI/CD

![github ci/cd](task_3/github_ci_cd.png)


### Proxy в Kubernetes

#### Шаг 1

Настроил [dockerconfigsecret](src/kubernetes/dockerconfigsecret.yaml)

#### Шаг 2

Доработал [events-service](src/kubernetes/events-service.yaml), [movies-service](src/kubernetes/movies-service.yaml), [monolith](src/kubernetes/monolith.yaml) 

[Proxy-service](src/kubernetes/proxy-service.yaml) сделал иначе. Из-за особенностей настройки `kong.yml`, а именно - невозможности извне прокинуть энвы в этот конфиг, я решил настроить отдельно конфиг-мапу для конга. Образ я также тяну официальный конговский, настраиваю в деплойменте контейнеры с конговскими энвами, монтирую конфиг-мапу и всё работает.

#### Шаг 3

Скриншот вывода при вызове https://cinemaabyss.example.com/api/movies:

![api_movies](task_3/api_movies.png)

Скриншот тестов:

![kuber_tests](task_3/kuber_tests.png)

Скриншот вывода event-service логов после вызова тестов:

![events_logs](task_3/events_logs.png)


## Задание 4

Скриншот развертывания helm:

![helm pods](task_4/helm_pods.png)

![helm](task_4/helm.png)

Скриншот вывода при вызове https://cinemaabyss.example.com/api/movies:

![api movies ap](task_4/api_movies.png)


# Задание 5

Скриншоты работы circuit-breaker:

![istio_1](task_5/istio_1.png)

![istio_2](task_5/istio_2.png)
