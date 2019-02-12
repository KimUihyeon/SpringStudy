<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://unpkg.com/element-ui@1.4/lib/theme-default/index.css">
  <link rel="stylesheet" href="/resources/Asset/Css/bulma.min.css">

  <title></title>
</head>
<body>
    
<style>
        .box {
          margin: 5px !important;
        }
      
        nav {
          border-bottom: 1px solid #e2e2e2;
          padding: 5px;
        }
      
        section .numberControl {
          text-align: center;
        }
      
        nav .navBox {
          margin: 8px;
        }
      
        nav .filterContainer {
          margin: 0px 12px;
        }
      
        nav .filter {
          font-size: 12px;
        }
      </style>
      <div id="mainApp">
        <template>
          <div>
            <!--ë©ì¸ Wrap-->
            <nav>
              <!--Nav-->
              <div class="navBox">
                <div class="columns">
                  <div class="column is-four-fifth">
                    <el-input placeholder="Pick a date"
                              icon="search"
                              v-model="searchEngine.input">
                    </el-input>
                  </div>
                  <div class="filterContainer">
                    <span class="filter" @@click="toggleFilterWindow()">ê²ìíí°</span>
                    <el-collapse-transition>
                      <div v-show="searchEngine.filterOpen">
                        <el-checkbox v-model="checked">Option</el-checkbox>
                        <el-checkbox v-model="checked">Option</el-checkbox>
                        <el-checkbox v-model="checked">Option</el-checkbox>
                        <el-checkbox v-model="checked">Option</el-checkbox>
                        <el-checkbox v-model="checked">Option</el-checkbox>
                      </div>
                    </el-collapse-transition>
                  </div>
      
                  <!-- <el-button type="text" @@click="dlgVisible = true">click to open the Dialog</el-button> -->
                </div>
              </div>
            </nav><!--Nav End-->
      
            <section>
              <!--Section-->
              <div class="box" v-for="post in posts">
                <div class="field is-grouped is-grouped-multiline">
                  <div class="control">
                    <div class="tags has-addons">
                      <span class="tag is-dark">Title</span>
                      <span class="tag is-info">{{post.ì ëª©}}</span>
                    </div>
                  </div>
      
                  <div class="control">
                    <div class="tags has-addons">
                      <span class="tag is-dark">í´ë¦­ì</span>
                      <span class="tag is-success">3</span>
                    </div>
                  </div>
      
                  <div class="control">
                    <div class="tags has-addons">
                      <span class="tag is-dark">Ctg</span>
                      <span class="tag is-success">{{post.ì¹´íê³ ë¦¬ìì´ë}}</span>
                    </div>
                  </div>
                </div>
                <div>
                  <video  width="320" height="240" controls>
                    <source  src="/Contents/Upload/[Thz.la]mide-381.mp4" type="video/mp4"/>
                  </video>
                </div>
                <div v-for="Image in post.files">
                  <img v-bind:src="'../Content/Upload/'+Image.íì¼ê²½ë¡" @@click="showDlg(post)" />
                </div>
                <div class="tags" v-for="tag in post.Tags">
                  <span class="tag">One</span>
                  <span class="tag">Two</span>
                  <span class="tag">Three</span>
                </div>
              </div>
              
              <div class="box">
                <div class="field is-grouped is-grouped-multiline">
                  <div class="control">
                    <div class="tags has-addons">
                      <span class="tag is-dark"></span>
                      <span class="tag is-info"></span>
                    </div>
                  </div>
      
                  <div class="control">
                    <div class="tags has-addons">
                      <span class="tag is-dark"></span>
                      <span class="tag is-success"></span>
                    </div>
                  </div>
      
                  <div class="control">
                    <div class="tags has-addons">
                      <span class="tag is-dark"></span>
                      <span class="tag is-success"></span>
                    </div>
                  </div>
                </div>
                <div>
                  <video  width="320" height="240" controls>
                    <source  src="./Contents/300NTK-020.mp4" type="video/mp4"/>
                  </video>
                </div>
                <div v-for="Image in post.files">
                  <img v-bind:src="'../Content/Upload/'+Image.íì¼ê²½ë¡" @@click="showDlg(post)" />
                </div>
                <div class="tags" v-for="tag in post.Tags">
                  <span class="tag">One</span>
                  <span class="tag">Two</span>
                  <span class="tag">Three</span>
                </div>
              </div>

              
              <div class="box">
                <div class="field is-grouped is-grouped-multiline">
                  <div class="control">
                    <div class="tags has-addons">
                      <span class="tag is-dark"></span>
                      <span class="tag is-info"></span>
                    </div>
                  </div>
      
                  <div class="control">
                    <div class="tags has-addons">
                      <span class="tag is-dark"></span>
                      <span class="tag is-success"></span>
                    </div>
                  </div>
      
                  <div class="control">
                    <div class="tags has-addons">
                      <span class="tag is-dark"></span>
                      <span class="tag is-success"></span>
                    </div>
                  </div>
                </div>
                <div>
                  <img src="./Contents/tumblr_on6ojwtvWm1u63xjyo4_1280.jpg" v-on:click="showDlg(post)"  />
                </div>
                <div v-for="Image in post.files">
                  <img v-bind:src="'../Content/Upload/'+Image.íì¼ê²½ë¡" v-on:click="showDlg(post)" />
                </div>
                <div class="tags" v-for="tag in post.Tags">
                  <span class="tag">One</span>
                  <span class="tag">Two</span>
                  <span class="tag">Three</span>
                </div>
              </div>

              <div class="numberControl">
                <el-button-group>
                  <el-button type="primary" size="small" icon="arrow-left"></el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small">1</el-button>
                  <el-button type="primary" size="small"><i class="el-icon-arrow-right el-icon-right"></i></el-button>
                </el-button-group>
              </div>
            </section><!--Section End-->
          </div><!--ë©ì¸ Wrap End-->
      
      
          <div>
            <!--Modal-->
            <el-dialog title="Tips" :visible.sync="dlgVisible" size="large">
              <div class="field is-grouped is-grouped-multiline">
                <div class="control">
                  <div class="tags has-addons">
                    <span class="tag is-dark">Title</span>
                    <span class="tag is-info">{{post.ì ëª©}}</span>
                  </div>
                </div>
                <div class="control">
                  <div class="tags has-addons">
                    <span class="tag is-dark">í´ë¦­ì</span>
                    <span class="tag is-success">3</span>
                  </div>
                </div>
      
                <div class="control">
                  <div class="tags has-addons">
                    <span class="tag is-dark">Ctg</span>
                    <span class="tag is-success">{{post.ì¹´íê³ ë¦¬ìì´ë}}</span>
                  </div>
                </div>
              </div>
              <div v-for="Image in post.files">
                <img v-bind:src="'/resources/Content/Upload/'+Image.íì¼ê²½ë¡" @@click="showDlg()" />
              </div>
              <div class="tags" v-for="tag in post.Tags">
                <span class="tag">One</span>
                <span class="tag">Two</span>
                <span class="tag">Three</span>
              </div>
              <span slot="footer" class="dialog-footer"></span>
            </el-dialog>
          </div><!--Modal end-->
      
        </template>
      </div>
      


  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/vue"></script>
  <script src="https://unpkg.com/element-ui@1.4/lib/index.js"></script>
  <script src="Asset/Js/common.js"></script>

  <script>
    var loadPostData  = {};

    var vm = new Vue({
      el: '#mainApp',
      data: {
        dlgVisible: false,
        pageState: '',
        searchEngine: {
          input: '',
          filterOpen: false,
          filter: {
          }
        },
        posts: {},
        post: {},
        checked: ''
      },
      mounted: function () {
        this.pageState = appConfig.pageState.list;
        this.posts = loadPostData;
      },

      methods: {
        toggleFilterWindow: function () {
          var isOpenFilterWindow = this.searchEngine.filterOpen;
          if (isOpenFilterWindow == true) {
            this.searchEngine.filterOpen = false;
          } else {
            this.searchEngine.filterOpen = true;
          }
        },

        showDlg: function (post) {
          this.dlgVisible = true;
          this.post = post;
          console.log("tt");
        },

        movePage: function (index) {

        }
      }
    });
  </script>

</body>
</html>