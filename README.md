OpenVoters - Android library
===========

An Android library that will make you connect to an OpenVoters-powered server.

Please refer to http://www.openvoters.org for more detailed information.


Installation
------------

The tool requires you to add this library in your editor and establish a dependency from your project to the library itself.

Usage
-----

The tool must be configured when your application launches, or at lease before starting using the remote API calls, by setting the base URL where your OpenVoters-powered server resides:

```java

RemoteAPI.setBaseURL("http://openvoters.myprivateserver.com/api/");
```

You will be then able to call the static remote API methods in the `RemoteAPI` class.