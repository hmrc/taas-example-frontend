/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.taasexamplefrontend.controllers

import play.api.test.FakeRequest
import play.api.mvc.Result

import scala.concurrent.duration.Duration
import scala.concurrent.Await

import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}


class HelloWorldControllerSpec extends UnitSpec with WithFakeApplication {


  "FAKE /" should {
    "be a fake test" in {
      1 shouldBe 1
    }
  }


  /* =========================================================================================
    Disabled temporarily to allow application to build on ci-open */

  val fakeRequest = FakeRequest("GET", "/taas-example-frontend/hello-world")
  val action = new HelloWorld().helloWorld
  val fa = fakeApplication

  "GET /taas-example-frontend/" should {
    "return an http status 200" in {
      val result: Result = Await.ready(action.apply(fakeRequest), Duration(10, "seconds"))
      result.header.status shouldBe  200
    }

    "return a text/html Content-Type" in {
      val result: Result = Await.ready(action.apply(fakeRequest), Duration(10, "seconds"))
      result.body.contentType.getOrElse("") should include("text/html")
    }
  }
  /*============================================================================================
  */

}