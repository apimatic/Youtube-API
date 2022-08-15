# Simple List Search

```java
SimpleListSearchController simpleListSearchController = client.getSimpleListSearchController();
```

## Class Name

`SimpleListSearchController`


# Search

Search API to search videos on Youtube based on a keyword.

```java
CompletableFuture<String> searchAsync(
    final String type,
    final String q,
    final String key,
    final String accept)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `type` | `String` | Query, Required | The part parameter specifies a comma-separated list of one or more search resource properties that the API response will include. Set the parameter value to snippet. |
| `q` | `String` | Query, Required | Keyword. |
| `key` | `String` | Query, Required | auth key |
| `accept` | `String` | Header, Required | - |

## Response Type

`String`

## Example Usage

```java
String type = "video";
String q = "surfing";
String key = "AIzaSyAp3aGvE_woRhDfY5i8MtzASxP9gSuEkHM";
String accept = "application/json";

simpleListSearchController.searchAsync(type, q, key, accept).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Example Response

```
"list"
```

