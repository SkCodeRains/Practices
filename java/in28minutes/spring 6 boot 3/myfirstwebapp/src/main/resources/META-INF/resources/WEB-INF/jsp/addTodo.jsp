<%@ include file="common/header.jsp" %>
    <%@ include file="common/navigation.jsp" %>
        <div class="container right-panel-active">
            <div class="container__form container--signin">
                <!-- <form class="form" id="form2" method="post" modelAttribute="todo">
                    <h2 class="form__title">Add Todo</h2>
                    <input type="text" name="description" class="input" required />
                    <button type="submit" class="btn">Add Todo</button>
                </form> -->

                <form:form method="post" modelAttribute="todo" class="form" id="form2">
                    <fieldset class="border-0 mb-5  ">
                        <form:label path="description" for="description">Description</form:label>
                        <form:input type="text" id="description" path="description" class="input" required="required" />
                        <form:errors path="description" />
                    </fieldset>


                    <fieldset class="border-0 ">
                        <form:label path="targetDate" for="targetDate">Target Date</form:label>
                        <form:input type="text" id="targetDate" path="targetDate" class="input" required="required" />
                        <br>
                        <form:errors path="targetDate" class="text-warning w-100" />
                    </fieldset>
                    <form:input type="hidden" path="id" />
                    <form:input type="hidden" path="done" />
                    <button type="submit" class="btn mt-3 ">SUBMIT</button>
                </form:form>
            </div>
        </div>

        <%@ include file="common/footer.jsp" %>