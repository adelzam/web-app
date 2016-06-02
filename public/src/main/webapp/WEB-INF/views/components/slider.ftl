<#-- @ftlvariable name="departure" type="java.util.List<com.springapp.mvc.common.AirportInfo>" -->
<#-- @ftlvariable name="arrival" type="java.util.List<com.springapp.mvc.common.AirportInfo>" -->
<!-- Header Carousel -->
<header id="myCarousel" class="carousel slide">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" style="z-index: 1;position: relative;">
        <div class="item active">
            <div class="fill" style="background-image:url('/resources/img/malaga.jpg');"></div>
            com.springapp.mvc.controllers.aspects
            <div class="carousel-caption">
                <h2>Окунуться в лето</h2>
            </div>
        </div>
        <div class="item">
            <div class="fill" style="background-image:url('/resources/img/2.jpg');"></div>
            <div class="carousel-caption">
                <h2>Встречать рассветы</h2>
            </div>
        </div>
        <div class="item">
            <div class="fill" style="background-image:url('/resources/img/3.jpg');"></div>
            <div class="carousel-caption">
                <h2>Навстречу лету</h2>
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="icon-prev"></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="icon-next"></span>
    </a>
    <div style="width: 1237px; height: 128px; margin-left: 101px;margin-top: -250px; position: relative; background-color: rgba(66,66,66,0.8); align-items: center; z-index: 5;">
        <form method="post" name="searchForm" action="/search/results">
            <div>
                <input name="dep" tabindex="1"
                       style="width: 307px; height: 48px; font-size: 25px; float: left; margin-top: 40px; margin-left: 7px"
                       list="dep_list" value="">
                </input>
                <datalist id="dep_list">
                <#if departure??>
                    <#list departure as item>
                        <option value="${item.name}">${item.name}, ${item.city}</option>
                    </#list>
                </#if>
                </datalist>
            </div>
            <div style="height: 48px; width: 43px; float: left ;margin-top: 40px;margin-left: 5px "></div>
            <div>
                <input tabindex="2" name="arr"
                       style="width: 307px; height: 48px; font-size: 25px; float: left; margin-top: 40px; margin-left: 5px" value="" list="arr_list"/>
                <datalist id="arr_list">
                <#if arrival??>
                    <#list arrival as item>
                        <option value="${item.name}">${item.name}, ${item.city}</option>
                    </#list>
                </#if>
                </datalist>
            </div>
            <div>
                <input type="date" name="date" value="2016-06-02" min="2016-06-02"
                       style="width: 268px; height: 48px; font-size: 25px; float: left; margin-top: 40px; margin-left: 5px">
            </div>
            <div>
                <input type="number" name="num" max="6" min="1" value="1"
                       style="width: 182px; height: 48px; font-size: 25px; float: left; margin-top: 40px;margin-left: 5px">
            </div>
            <div>
                <input type="submit" value="НАЙТИ" style="width: 88px; height: 48px; float: left; margin-top: 40px; margin-left: 5px
                " min="0" max="6">
            </div>
        </form>
    </div>
</header>
