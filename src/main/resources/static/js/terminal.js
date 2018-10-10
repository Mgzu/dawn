define(function() {
  "use strict";

  var statistics = function(x, y) {
    return x + y;
  };

  var createProxy = function(x, y) {
    return x + y;
  };

  return {
    statistics: statistics
  };
});
