# Redis

## Pub/Sub
广播式

### publish
```sh
PUBLISH foo bar
```
### subscribe
```sh
SUBSCRIBE foo [foo2 ...]
```
### psubscribe
```sh
PSUBSCRIBE foo*
```
> `PSUBSCRIBE foo*`相当于同时订阅 `foo1`, `foo2`...
