---
title: My Project
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.28"

---

# My Project

Base URLs:

# Authentication

# Resto/BookingController

## GET findAllBookings

GET /api/v1/bookings

> Response Examples

```json
{
  "content": [
    {
      "id": 0,
      "customer": {
        "id": 0,
        "name": "",
        "email": "",
        "phone": "",
        "createdAt": ""
      },
      "pax": 0,
      "bookingDatetime": "",
      "message": "",
      "status": "",
      "createdAt": "",
      "updatedAt": ""
    }
  ],
  "pageable": {
    "paged": false,
    "unpaged": false,
    "pageNumber": 0,
    "pageSize": 0,
    "offset": 0,
    "sort": [
      {
        "direction": "",
        "property": "",
        "ignoreCase": false,
        "nullHandling": "",
        "ascending": false,
        "descending": false
      }
    ]
  },
  "total": 0,
  "empty": false,
  "number": 0,
  "size": 0,
  "numberOfElements": 0,
  "sort": [
    {
      "direction": "",
      "property": "",
      "ignoreCase": false,
      "nullHandling": "",
      "ascending": false,
      "descending": false
    }
  ],
  "first": false,
  "last": false,
  "totalPages": 0,
  "totalElements": 0
}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResponseEntityPageBookingDto](#schemaresponseentitypagebookingdto)|

## GET findBookingById

GET /api/v1/bookings/find/{id}

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer| yes |none|

> Response Examples

```json
{
  "id": 0,
  "customer": {
    "id": 0,
    "name": "",
    "email": "",
    "phone": "",
    "createdAt": ""
  },
  "pax": 0,
  "bookingDatetime": "",
  "message": "",
  "status": "",
  "createdAt": "",
  "updatedAt": ""
}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResponseEntityBookingDto](#schemaresponseentitybookingdto)|

## POST saveBooking

POST /api/v1/bookings/save

> Body Parameters

```json
{
  "id": 0,
  "customer": {},
  "pax": 0,
  "bookingDatetime": "string",
  "message": "string",
  "status": "string",
  "createdAt": "string",
  "updatedAt": "string"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|[BookingDto](#schemabookingdto)| no |none|

> Response Examples

```json
{
  "id": 0,
  "customer": {
    "id": 0,
    "name": "",
    "email": "",
    "phone": "",
    "createdAt": ""
  },
  "pax": 0,
  "bookingDatetime": "",
  "message": "",
  "status": "",
  "createdAt": "",
  "updatedAt": ""
}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResponseEntityBookingDto](#schemaresponseentitybookingdto)|

## DELETE deleteBookingById

DELETE /api/v1/bookings/delete/{id}

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|id|path|integer| yes |none|

> Response Examples

```json
null
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|string|

# Data Schema

<h2 id="tocS_CustomerDto">CustomerDto</h2>

<a id="schemacustomerdto"></a>
<a id="schema_CustomerDto"></a>
<a id="tocScustomerdto"></a>
<a id="tocscustomerdto"></a>

```json
{
  "id": 0,
  "name": "string",
  "email": "string",
  "phone": "string",
  "createdAt": "string"
}

```

### Attribute

|Name|Type|Required|Restrictions|Title|Description|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|name|string|true|none||none|
|email|string|true|none||none|
|phone|string|true|none||none|
|createdAt|string|false|none||none|

<h2 id="tocS_Sort">Sort</h2>

<a id="schemasort"></a>
<a id="schema_Sort"></a>
<a id="tocSsort"></a>
<a id="tocssort"></a>

```json
{
  "direction": "ASC",
  "property": "string",
  "ignoreCase": true,
  "nullHandling": "NATIVE",
  "ascending": true,
  "descending": true
}

```

### Attribute

|Name|Type|Required|Restrictions|Title|Description|
|---|---|---|---|---|---|
|direction|string|false|none||none|
|property|string|false|none||none|
|ignoreCase|boolean|false|none||none|
|nullHandling|string|false|none||none|
|ascending|boolean|false|none||none|
|descending|boolean|false|none||none|

#### Enum

|Name|Value|
|---|---|
|direction|ASC|
|direction|DESC|
|nullHandling|NATIVE|
|nullHandling|NULLS_FIRST|
|nullHandling|NULLS_LAST|

<h2 id="tocS_BookingDto">BookingDto</h2>

<a id="schemabookingdto"></a>
<a id="schema_BookingDto"></a>
<a id="tocSbookingdto"></a>
<a id="tocsbookingdto"></a>

```json
{
  "id": 0,
  "customer": {},
  "pax": 0,
  "bookingDatetime": "string",
  "message": "string",
  "status": "string",
  "createdAt": "string",
  "updatedAt": "string"
}

```

### Attribute

|Name|Type|Required|Restrictions|Title|Description|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|customer|object|true|none||none|
|pax|integer|false|none||none|
|bookingDatetime|string|true|none||none|
|message|string|false|none||none|
|status|string|false|none||none|
|createdAt|string|false|none||none|
|updatedAt|string|false|none||none|

<h2 id="tocS_ResponseEntityPageBookingDto">ResponseEntityPageBookingDto</h2>

<a id="schemaresponseentitypagebookingdto"></a>
<a id="schema_ResponseEntityPageBookingDto"></a>
<a id="tocSresponseentitypagebookingdto"></a>
<a id="tocsresponseentitypagebookingdto"></a>

```json
{
  "content": [
    {
      "id": 0,
      "customer": {},
      "pax": 0,
      "bookingDatetime": "string",
      "message": "string",
      "status": "string",
      "createdAt": "string",
      "updatedAt": "string"
    }
  ],
  "pageable": {},
  "total": 0,
  "empty": true,
  "number": 0,
  "size": 0,
  "numberOfElements": 0,
  "sort": [
    {
      "direction": "ASC",
      "property": "string",
      "ignoreCase": true,
      "nullHandling": "NATIVE",
      "ascending": true,
      "descending": true
    }
  ],
  "first": true,
  "last": true,
  "totalPages": 0,
  "totalElements": 0
}

```

### Attribute

|Name|Type|Required|Restrictions|Title|Description|
|---|---|---|---|---|---|
|content|[[BookingDto](#schemabookingdto)]|false|none||none|
|pageable|object|false|none||none|
|total|integer(int64)|false|none||none|
|empty|boolean|false|none||none|
|number|integer|false|none||none|
|size|integer|false|none||none|
|numberOfElements|integer|false|none||none|
|sort|[[Sort](#schemasort)]|false|none||none|
|first|boolean|false|none||none|
|last|boolean|false|none||none|
|totalPages|integer|false|none||none|
|totalElements|integer(int64)|false|none||none|

<h2 id="tocS_Pageable">Pageable</h2>

<a id="schemapageable"></a>
<a id="schema_Pageable"></a>
<a id="tocSpageable"></a>
<a id="tocspageable"></a>

```json
{
  "paged": true,
  "unpaged": true,
  "pageNumber": 0,
  "pageSize": 0,
  "offset": 0,
  "sort": [
    {
      "direction": "ASC",
      "property": "string",
      "ignoreCase": true,
      "nullHandling": "NATIVE",
      "ascending": true,
      "descending": true
    }
  ]
}

```

### Attribute

|Name|Type|Required|Restrictions|Title|Description|
|---|---|---|---|---|---|
|paged|boolean|false|none||none|
|unpaged|boolean|false|none||none|
|pageNumber|integer|false|none||none|
|pageSize|integer|false|none||none|
|offset|integer(int64)|false|none||none|
|sort|[[Sort](#schemasort)]|false|none||none|

<h2 id="tocS_ResponseEntityBookingDto">ResponseEntityBookingDto</h2>

<a id="schemaresponseentitybookingdto"></a>
<a id="schema_ResponseEntityBookingDto"></a>
<a id="tocSresponseentitybookingdto"></a>
<a id="tocsresponseentitybookingdto"></a>

```json
{
  "id": 0,
  "customer": {},
  "pax": 0,
  "bookingDatetime": "string",
  "message": "string",
  "status": "string",
  "createdAt": "string",
  "updatedAt": "string"
}

```

### Attribute

|Name|Type|Required|Restrictions|Title|Description|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|customer|object|true|none||none|
|pax|integer|false|none||none|
|bookingDatetime|string|true|none||none|
|message|string|false|none||none|
|status|string|false|none||none|
|createdAt|string|false|none||none|
|updatedAt|string|false|none||none|

