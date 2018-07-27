(function() {
  var _default_options = {
    pageNum: 1,
    pageSize: 10,
    title: [], // table's title
    data_title: [], // data's title
    data: [],
    countPage: 1,
    dataUpdate: ""
  };

  function createLoading() {
    var _body = document.body;
    var _loading =
      '	<div class="loading-cover"><div class="loading-spinner"><div class="loading-rect1"></div><div class="loading-rect2"></div><div class="loading-rect3"></div><div class="loading-rect4"></div><div class="loading-rect5"></div></div></div>';
    _body.insertAdjacentHTML("afterbegin", _loading);
  }

  function paging() {
    var _pagination = document.querySelector(".pagination-plugin");
    var _insert_thead = "",
      _insert_tbody = "",
      _insert_foot_page = "";
    var i,
      j,
      tr_data,
      td_data,
      chip_data,
      title_length = _default_options.title.length,
      length = _default_options.pageSize;
    for (i = 0; i < title_length; i++) {
      _insert_thead += "<th>" + _default_options.title[i] + "</th>";
    }
    title_length = _default_options.data_title.length;
    // 无数据时也要循环对应的次数
    for (i = 0; i < length; i++) {
      tr_data = "";
      td_data = _default_options.data[i];
      for (j = 0; j < title_length - 1; j++) {
        if (undefined != td_data) {
          if (undefined == td_data[_default_options.data_title[j + 1]]) {
            tr_data += "<th></th>";
          } else {
            tr_data +=
              "<th>" + td_data[_default_options.data_title[j + 1]] + "</th>";
          }
        } else {
          tr_data += "<th></th>";
        }
      }
      _insert_tbody += "<tr><th>" + (i + 1) + "</th>" + tr_data + "</tr>";
    }

    if (_default_options.countPage > 1) {
      for (i = 0; i < _default_options.countPage; i++) {
        chip_data = "";
        switch (i) {
          case 0:
            if (_default_options.pageNum - 1 == 0) {
              chip_data =
                '<div class="mdui-chip"><span class="mdui-chip-title pagination-disabled">上一页</span></div><div class="mdui-chip pagination-currentPage"><span class="mdui-chip-title">' +
                (i + 1) +
                "</span></div>";
            } else {
              chip_data =
                '<div class="mdui-chip"><span class="mdui-chip-title" onclick="prevPage()">上一页</span></div><div class="mdui-chip" onclick="goPage(' +
                (i + 1) +
                ')"><span class="mdui-chip-title">' +
                (i + 1) +
                "</span></div>";
            }
            break;
          case _default_options.pageNum - 1:
            if (i == _default_options.countPage - 1) {
              chip_data =
                '<div class="mdui-chip pagination-currentPage"><span class="mdui-chip-title">' +
                (i + 1) +
                '</span></div><div class="mdui-chip"><span class="mdui-chip-title pagination-disabled">下一页</span></div>';
            } else {
              chip_data =
                '<div class="mdui-chip pagination-currentPage"><span class="mdui-chip-title">' +
                (i + 1) +
                "</span></div>";
            }
            break;
          case _default_options.countPage - 1:
            chip_data =
              '<div class="mdui-chip" onclick="goPage(' +
              (i + 1) +
              ')"><span class="mdui-chip-title">' +
              (i + 1) +
              '</span></div><div class="mdui-chip" onclick="nextPage()"><span class="mdui-chip-title">下一页</span></div>';
            break;
          default:
            chip_data =
              '<div class="mdui-chip" onclick="goPage(' +
              (i + 1) +
              ')"><span class="mdui-chip-title">' +
              (i + 1) +
              "</span></div>";
            break;
        }
        _insert_foot_page += chip_data;
      }
    } else {
      _insert_foot_page +=
        '<div class="mdui-chip"><span class="mdui-chip-title pagination-disabled">上一页</span></div><div class="mdui-chip pagination-currentPage"><span class="mdui-chip-title">1</span></div><div class="mdui-chip"><span class="mdui-chip-title pagination-disabled">下一页</span></div>';
    }

    var _insert =
      '<div class="mdui-container"><div class="mdui-table-fluid"><table class="mdui-table"><thead class="pagination-table-thead"><tr>' +
      _insert_thead +
      '</tr></thead><tbody class="pagination-table-tbody">' +
      _insert_tbody +
      '</tbody></table></div></div><div class="mdui-container mdui-valign"><div class="pagination-foot mdui-valign"><span class="pagination-foot-page">' +
      _insert_foot_page +
      '</span><span style="margin-left: 10px;"><span>页数：</span><select class="mdui-select" id="pagination-pagesize" onchange="changePageSize()" mdui-select><option value="5">5</option><option value="10">10</option><option value="15">15</option><option value="20">20</option><option value="30">30</option><option value="40">40</option><option value="50">50</option></select></span></div></div>';
    _pagination.insertAdjacentHTML("afterbegin", _insert);
  }

  function refreshTbody() {
    clearTbody();
    var _tbody = document.querySelector(".pagination-table-tbody");
    var _insert_tbody = "";
    var i,
      j,
      tr_data,
      td_data,
      title_length = _default_options.title.length,
      length = _default_options.pageSize;
    // 无数据时也要循环对应的次数
    for (i = 0; i < length; i++) {
      tr_data = "";
      td_data = _default_options.data[i];
      for (j = 0; j < title_length - 1; j++) {
        if (undefined != td_data) {
          if (undefined == td_data[_default_options.data_title[j + 1]]) {
            tr_data += "<th></th>";
          } else {
            tr_data +=
              "<th>" + td_data[_default_options.data_title[j + 1]] + "</th>";
          }
        } else {
          tr_data += "<th></th>";
        }
      }
      _insert_tbody += "<tr><th>" + (i + 1) + "</th>" + tr_data + "</tr>";
    }
    _tbody.insertAdjacentHTML("afterbegin", _insert_tbody);
  }

  function refreshPaginationFoot() {
    clearPaginationFoot();
    var _pagination_foot = document.querySelector(".pagination-foot-page");
    var _insert_foot_page = "",
      chip_data;
    if (_default_options.countPage > 1) {
      for (var i = 0; i < _default_options.countPage; i++) {
        chip_data = "";
        switch (i) {
          case 0:
            if (_default_options.pageNum - 1 == 0) {
              chip_data =
                '<div class="mdui-chip"><span class="mdui-chip-title pagination-disabled">上一页</span></div><div class="mdui-chip pagination-currentPage"><span class="mdui-chip-title">' +
                (i + 1) +
                "</span></div>";
            } else {
              chip_data =
                '<div class="mdui-chip"><span class="mdui-chip-title" onclick="prevPage()">上一页</span></div><div class="mdui-chip" onclick="goPage(' +
                (i + 1) +
                ')"><span class="mdui-chip-title">' +
                (i + 1) +
                "</span></div>";
            }
            break;
          case _default_options.pageNum - 1:
            // 如果两个 case 同时成立，switch 会默认选择第一个 case。
            if (i == _default_options.countPage - 1) {
              chip_data =
                '<div class="mdui-chip pagination-currentPage"><span class="mdui-chip-title">' +
                (i + 1) +
                '</span></div><div class="mdui-chip"><span class="mdui-chip-title pagination-disabled">下一页</span></div>';
            } else {
              chip_data =
                '<div class="mdui-chip pagination-currentPage"><span class="mdui-chip-title">' +
                (i + 1) +
                "</span></div>";
            }
            break;
          case _default_options.countPage - 1:
            chip_data =
              '<div class="mdui-chip" onclick="goPage(' +
              (i + 1) +
              ')"><span class="mdui-chip-title">' +
              (i + 1) +
              '</span></div><div class="mdui-chip" onclick="nextPage()"><span class="mdui-chip-title">下一页</span></div>';
            break;
          default:
            chip_data =
              '<div class="mdui-chip" onclick="goPage(' +
              (i + 1) +
              ')"><span class="mdui-chip-title">' +
              (i + 1) +
              "</span></div>";
            break;
        }
        _insert_foot_page += chip_data;
      }
    } else {
      _insert_foot_page +=
        '<div class="mdui-chip"><span class="mdui-chip-title pagination-disabled">上一页</span></div><div class="mdui-chip pagination-currentPage"><span class="mdui-chip-title">1</span></div><div class="mdui-chip"><span class="mdui-chip-title pagination-disabled">下一页</span></div>';
    }
    _pagination_foot.insertAdjacentHTML("afterbegin", _insert_foot_page);
  }

  function clearTbody() {
    var tbody = document.querySelector(".pagination-table-tbody");
    tbody.innerHTML = "";
  }

  function clearPaginationFoot() {
    var pageNum_list = document.querySelector(".pagination-foot-page");
    pageNum_list.innerHTML = "";
  }

  var _mdui_pagination = {
    init: function(options) {
      _default_options.pageNum = options.pageNum || _default_options.pageNum;
      _default_options.pageSize = options.pageSize || _default_options.pageSize;
      _default_options.title = options.title || _default_options.title;
      _default_options.data_title =
        options.data_title || _default_options.data_title;
      _default_options.data = options.data || _default_options.data;
      _default_options.countPage =
        options.countPage || _default_options.countPage;
      createLoading();
      paging();
    },
    setOptions: function(options) {
      _default_options.pageNum = options.pageNum || _default_options.pageNum;
      _default_options.pageSize = options.pageSize || _default_options.pageSize;
      _default_options.title = options.title || _default_options.title;
      _default_options.data_title =
        options.data_title || _default_options.data_title;
      _default_options.data = options.data || _default_options.data;
      _default_options.countPage =
        options.countPage || _default_options.countPage;
    },
    getOptions: function() {
      return _default_options;
    },
    clear: function() {
      var pageNum_list = document.querySelector(".pagination-plugin");
      pageNum_list.innerHTML = "";
    },
    update: function() {
      refreshTbody();
      refreshPaginationFoot();
    }
  };

  this.mduiPagination = _mdui_pagination;
})();

function openLoading() {
  document.getElementsByClassName("loading-cover")[0].style.display = "block";
}

function closeLoading() {
  document.getElementsByClassName("loading-cover")[0].style.display = "none";
}

// 此处调用闭包内的函数
// div绑定的事件
function goPage(pageNum) {
  // 1.open loading annimate and set pageNum
  openLoading();
  var options = this.mduiPagination.getOptions();
  options.pageNum = pageNum;
  // 2.get data
  var data = getData(options.pageNum, options.pageSize);
  // 3.setOptios
  this.mduiPagination.setOptions(data);
  // 4.clear and paging,after close loading annimate
  this.mduiPagination.update();
  closeLoading();
}

function nextPage() {
  openLoading();
  var options = this.mduiPagination.getOptions();
  options.pageNum++;
  var data = getData(options.pageNum, options.pageSize);
  this.mduiPagination.setOptions(data);
  this.mduiPagination.update();
  closeLoading();
}

function prevPage() {
  openLoading();
  var options = this.mduiPagination.getOptions();
  options.pageNum--;
  var data = getData(options.pageNum, options.pageSize);
  this.mduiPagination.setOptions(data);
  this.mduiPagination.update();
  closeLoading();
}

function changePageSize() {
  // 1.open loading annimate and set pageSize
  openLoading();
  var options = this.mduiPagination.getOptions();
  options.pageSize = document.getElementById("pagination-pagesize").value;
  // 2.get data
  var data = getData(options.pageNum, options.pageSize);
  // 3.setOptios
  this.mduiPagination.setOptions(data);
  // 4.clear and paging,after close loading annimate
  this.mduiPagination.update();
  closeLoading();
}
