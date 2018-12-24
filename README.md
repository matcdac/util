# utility classes for

1) json mapper of any class (JsonUtil.java / GenericJsonUtil.java)
convert Object to JsonString, or JsonString to Object

2) logging Exception in json format (ExceptionLogUtil.java)
this provides better readibilty in AWS Cloud Watch, and easy to search, by providing whole paragraph of Exception log in one single line, just search for "exceptionTraceHeirarchy" or "exceptionMeta"
