# Games Info App Tutorial

An Android app that uses Retrofit to consume a gaming API. The app allows users to view details of different games and adapts to the light or dark theme of the device. The app is simple and user-friendly, making it a great resource for gamers.

## Libraries

- ViewBinding
- ViewModel
- Retrofit2
- Coil
- SwipeRefreshLayout
- Dagger Hilt

## Features

- Show a list of games
- See the details of each game


## API Reference

#### Live games list

```http
  GET https://www.freetogame.com/api/games
```

| Base Url                          | Parameter     | Type                       |
| :-------------------------------- | :------------ | :------------------------- |
| `https://www.freetogame.com/api/` | `games`       | `string`                   |

#### Return details from a specific game

```http
  GET https://www.freetogame.com/api/game?id=452
```

| Base Url                               | Parameter     | Type                              | Description                       |
| :------------------------------------- | :------------ | :-------------------------------- | :-------------------------------- |
| `https://www.freetogame.com/api/`      | `game?id=452` | `int`                             | **Required**. id of game          |

## Documentation

[Documentation](https://www.freetogame.com/api-doc)

## Tutorial on YouTube

[Tutorial on YouTube](https://youtu.be/D7lUPlUwS24)

![App Screenshot](https://pbs.twimg.com/media/FhUilFzXoAQ6QH7?format=jpg&name=large)
